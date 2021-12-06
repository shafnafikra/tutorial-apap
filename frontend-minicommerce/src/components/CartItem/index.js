import React from "react";
import classes from "./styles.module.css";
const CartItem = (props) => {
    const { idCart, title, price, description, category, quantity} = props;
    return (
        <div className={classes.cartItem}>
            <h3>{`ID Cart ${idCart}`}</h3>
            <p>{`Nama Barang: ${title}`}</p>
            <p>{`Harga: ${price}`}</p>
            <p>{`Jumlah: ${quantity}`}</p>
            <p>{`Deskripsi: ${description}`}</p>
            <p>{`Kategori: ${category}`}</p>
            <h3>{`Total Harga: ${quantity*price}`}</h3>
        </div>
    );
};
export default CartItem;
