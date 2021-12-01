import React, { Component } from "react";
import Layout from "./components/layout";
import ItemList from "./containers/itemlist";
import { BrowserRouter as Router, Switch, Route } from "react-router-dom";
import Cart from "./containers/cart";


class App extends Component {
  render() {
    return (
      <div>
        <Router>
          <Switch>
            <Route path="/" exact>
              <ItemList />
            </Route>
            <Route path="/cart" exact>
              <Cart />
            </Route>
          </Switch>
        </Router>
      </div>
    // <Layout>
    // <ItemList/>
    // </Layout>
    );
  }
}
export default App;