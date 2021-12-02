import React from "react";
import Button from "../button";
import classes from "./styles.module.css";
const Item = (props) => {
const { id, title, price, description, category, quantity, amount, handleEdit, handleDelete, handleAmountChange, handleAddToCart} = props;
return (
<div className={classes.item}>
    <h3>{`ID ${id}`}</h3>
    <p>{`Nama Barang: ${title}`}</p>
    <p>{`Harga: ${price}`}</p>
    <p>{`Deskripsi: ${description}`}</p>
    <p>{`Kategori: ${category}`}</p>
    <p>{`stok: ${quantity}`}</p>
    <Button action={handleEdit}>
        Edit
    </Button>
    <Button action={() => handleDelete(id)}>
        Delete
    </Button>
    <form>
        <div className={classes.flex}>
        <input
            className={classes.textField}
            type="number"
            placeholder="Jumlah item .." 
            name="jumlahItem"
            onChange={(e) => handleAmountChange(e.target.value, id, quantity)} 
        />
        <Button action={handleAddToCart} variant="button-custom">
            Add To Cart
        </Button>
        </div>
    </form>
</div>
);
};
export default Item;