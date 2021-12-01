import React, { Component } from "react";
import classes from "./styles.module.css";
import APIConfig from "../../api/APIConfig";
import Button from "../../components/button";
import { Link } from 'react-router-dom';
import CartItem from "../../components/CartItem";

class Cart extends Component {
    constructor(props) {
        super(props);
        this.state = {
            isLoading: false,
            isCreate: false,
            isEdit: false,
            items: [],
        };
        this.handleCheckout = this.handleCheckout.bind(this);
    }
    componentDidMount() {
        this.loadCartData();
        console.log("componentDidMount()");
    }

    async loadCartData() {
        try {
            const { data } = await APIConfig.get("/cart");
            this.setState({ items: data.result });
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    async handleCheckout(event) {
        event.preventDefault();
        try {
            await APIConfig.get("/cart/checkout");
            this.loadCartData();
        } catch (error) {
            alert("Oops terjadi masalah pada server");
            console.log(error);
        }
    }

    render() {
        return (
            <div className={classes.itemList}> 
                <div style={{display: "flex", justifyContent: "space-around", alignItems: "center"}}>
                <Link to="/">
                    <Button>
                        Back
                    </Button>
                </Link>
                <h1 className={classes.title}>
                    Cart Items
                </h1>
                <div>
                    {this.state.items.length > 0 && (
                        <Button action={this.handleCheckout}>
                            Checkout
                        </Button>
                    )}
                </div>
            </div>
                <div>
                    {this.state.items.map((item) => (
                    <CartItem
                        key={item.id}
                        idCart={item.id}
                        title={item.item.title} 
                        price={item.item.price} 
                        description={item.item.description} 
                        category={item.item.category} 
                        quantity={item.quantity}
                    />
                    ))} 
                </div>
            </div>
        );
    }
}
export default Cart;