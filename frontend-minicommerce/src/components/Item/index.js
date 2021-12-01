import React from "react";
import classes from "./styles.module.css";
const Item = (props) => {
const { id, title, price, description, category, quantity, handleEdit, handleDelete} = props;
return (
<div className={classes.item}>
<h3>{`ID ${id}`}</h3>
<p>{`Nama Barang: ${title}`}</p>
<p>{`Harga: ${price}`}</p>
<p>{`Deskripsi: ${description}`}</p>
<p>{`Kategori: ${category}`}</p>
<p>{`stok: ${quantity}`}</p>
</div>
);
};
export default Item;