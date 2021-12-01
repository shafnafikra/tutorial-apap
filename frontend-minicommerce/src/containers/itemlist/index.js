import React, { Component } from "react";
import Item from "../../components/Item";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";
import Button from "../../components/button";
import Modal from "../../components/modal";
import { Link } from 'react-router-dom';
import Badge from "@material-ui/core/Badge";
import ShoppingCartIcon from '@mui/icons-material/ShoppingCart';
import { Fab } from "@material-ui/core";

class ItemList extends Component {
    constructor(props) {
        super(props);
        this.state = {
            items: [
            ],
            isLoading: false,
            isCreate: false,
            isEdit: false,
            id: "",
            title: "",
            price: 0,
            description: "",
            category: "",
            quantity: 0,
            cartItems: [],
            targetItemAmount: 0,
            targetItemId: "",
            targetItemStock: 0,

        };
        this.handleClickLoading = this.handleClickLoading.bind(this);
        this.handleAddItem = this.handleAddItem.bind(this);
        this.handleCancel = this.handleCancel.bind(this);
        this.handleSubmitItem = this.handleSubmitItem.bind(this);
        this.handleChangeField = this.handleChangeField.bind(this);
        this.handleEditItem = this.handleEditItem.bind(this);
        this.handleDeleteItem = this.handleDeleteItem.bind(this);
        this.handleSubmitEditItem = this.handleSubmitEditItem.bind(this);
        this.handleSearchItem = this.handleSearchItem.bind(this);
        this.handleItemAmountChange = this.handleItemAmountChange.bind(this);
        this.handleAddToCart = this.handleAddToCart.bind(this);
    }
    componentDidMount() {
        this.loadData();
        this.loadCartData();
        console.log("componentDidMount()");
    }

    async loadData() {
        try {
            const { data } = await APIConfig.get("/item");
            this.setState({ items: data.result });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    async loadCartData() {
        try {
            const { data } = await APIConfig.get("/cart");
            this.setState({ cartItems: data.result });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }


    shouldComponentUpdate(nextProps, nextState) {
        console.log("shouldComponentUpdate()");
        return true;
    }

    handleClickLoading() {
        const currentLoading = this.state.isLoading;
        this.setState({ isLoading: !currentLoading });
        console.log(this.state.isLoading);
    }

    handleAddItem() {
        this.setState({ isCreate: true });
        console.log("masuk add item");
    }

    handleCancel(event) {
        event.preventDefault();
        this.setState({ isCreate: false, isEdit: false });
    }

    handleChangeField(event) {
        const { name, value } = event.target;
        this.setState({ [name]: value });
    }

    handleEditItem(item) {
        this.setState({
        isEdit: true,
        id: item.id,
        title: item.title,
        price: item.price,
        description: item.description,
        category: item.category,
        quantity: item.quantity
        })
    }

    async handleDeleteItem(itemId){
        try {
            await APIConfig.delete(`/item/${itemId}`);
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    async handleSubmitItem(event) {
        event.preventDefault();
        try {
            const data = {
                title: this.state.title,
                price: this.state.price,
                description: this.state.description,
                category: this.state.category,
                quantity: this.state.quantity
            };
            await APIConfig.post("/item", data);
            this.setState({
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");

            console.log(error);
        }
        this.handleCancel(event);
    }

    async handleSubmitEditItem(event) {
        event.preventDefault();
        try {
            const data = {
            title: this.state.title,
            price: this.state.price,
            description: this.state.description,
            category: this.state.category,
            quantity: this.state.quantity
            };
            await APIConfig.put(`/item/${this.state.id}`, data);
            this.setState({
                id: "",
                title: "",
                price: 0,
                description: "",
                category: "",
                quantity: 0
            })
            this.loadData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
        this.handleCancel(event);
    }

    async handleSearchItem(event){
        event.preventDefault();
        try{
            const title = this.state.title;
            const {data} = await APIConfig.get(`item?title=` + title);
            this.setState({ items: data.result});
            console.log(this.state.items);

        }catch (error){
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    async handleAddToCart(event){
        event.preventDefault();
        if (this.isItemOnStock()) {
            try {
                const data = {
                    idItem: this.state.targetItemId,
                    quantity: this.state.targetItemAmount
                };
                await APIConfig.post("/cart", data);
                this.loadData();
                this.loadCartData();
            } catch (error) {
                alert("Oops terjadi masalah pada server");
                console.log(error);
            }
        } else {
            alert("Oops the stock is insufficient");
        }
        
    }

    isItemOnStock(){
        var onCartAmount = this.state.cartItems.find(i => i.item.id === this.state.targetItemId)?.quantity || 0;
        var availableStock = this.state.targetItemStock - onCartAmount;
        console.log("onCartAmount ", onCartAmount)
        console.log("availableStock ", availableStock)
        console.log("targetItemAmount ", this.state.targetItemAmount)
        if (this.state.targetItemAmount > availableStock) {
            return false
        } else {
            return true;
        }
    }

    handleItemAmountChange(amount, itemId, itemStock){
        this.setState({
            targetItemAmount: amount,
            targetItemId: itemId,
            targetItemStock: itemStock,
        })
    }

    render() {
        return (
            <div className={classes.itemList}> <h1 className={classes.title}>
                All Items
            </h1>
            <Link to="/cart">
                <div style={{ position: "fixed", top: 25, right: 25 }}>
                    <Fab variant="extended">
                        <Badge
                            color="secondary"
                            badgeContent={this.state.cartItems.length}
                        >
                            <ShoppingCartIcon />
                        </Badge>
                    </Fab>
                </div>
            </Link>
                <div>

                <form> 
                        <input
                        className={classes.textField} type="text"
                        placeholder="Cari Item" name="title"
                        value={this.state.title} onChange={this.handleChangeField} />
                        <Button action={this.handleSearchItem}>
                        Search Item
                </Button>
                </form>
                <Button action={this.handleAddItem}>
                    Add Item
                </Button>
                    {this.state.items.map((item) => (
                    <Item
                        key={item.id}
                        id={item.id}
                        title={item.title} 
                        price={item.price} 
                        description={item.description} 
                        category={item.category} 
                        quantity={item.quantity}
                        handleEdit={() => this.handleEditItem(item)}
                        handleDelete={this.handleDeleteItem}
                        handleAmountChange={this.handleItemAmountChange}
                        handleAddToCart={this.handleAddToCart}
                    />
                    ))} </div>
                <Modal
                    show={this.state.isCreate || this.state.isEdit} handleCloseModal={this.handleCancel} modalTitle={this.state.isCreate
                        ? "Add Item"
                        : `Edit Item ID ${this.state.id}`} >
                    <form> 
                        <input
                        className={classes.textField} type="text"
                        placeholder="Nama Item" name="title"
                        value={this.state.title} onChange={this.handleChangeField} />
                        <input
                            className={classes.textField} type="number" placeholder="Harga"
                            name="price"
                            value={this.state.price} onChange={this.handleChangeField}
                        />
                        <textarea className={classes.textField} placeholder="Deskripsi" name="description"
                            rows="4"
                            value={this.state.description} onChange={this.handleChangeField}
                        />
                        <input
                            className={classes.textField} type="text"
                            placeholder="Kategori" name="category" value={this.state.category} onChange={this.handleChangeField}
                        />
                        <input
                            className={classes.textField} type="number"
                            placeholder="qty"
                            name="quantity" value={this.state.quantity} onChange={this.handleChangeField}
                        />
                       <Button action={this.state.isCreate
                            ? this.handleSubmitItem
                            : this.handleSubmitEditItem}
                            >
                            Create
                        </Button>
                        <Button action={this.handleCancel}>
                            Cancel
                        </Button> </form>
                </Modal> </div>
        );
    }


}
export default ItemList;