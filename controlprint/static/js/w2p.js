function WebStorage(){}

WebStorage.prototype.save = function(name,data){
	//convert data to json fot to save
	localStorage.setItem(name, JSON.stringify(data));
}

WebStorage.prototype.remove= function(name){
	localStorage.removeItem(name);
}

/**
	Class cart
	 The shopping cart
**/
function Cart(){
	//Singleton
	if ( arguments.callee._singletonInstance )
    	return arguments.callee._singletonInstance;
  	arguments.callee._singletonInstance = this;

	var today = new Date();
	this.products = [];
	this.date = today;
	this.user = "";
	this.total = 0;
	this.url = "cart.html";
}

Cart.prototype.sumProducts = function (){
	this.total = 0;
	products = this.products;
	for (i=0;i<products.length;i++){
		this.total += products[i];
	}
	return this.total
}

Cart.prototype.addProduct = function (product){
	this.products.push(product);
	this.save();
}

Cart.prototype.delProduct = function (index){
	this.products.splice(index, 1);
	this.save();
}

Cart.prototype.save = function(){
	localStorage.setItem("cart", JSON.stringify(this));
}

Cart.prototype.remove = function(){
	localStorage.removeItem("cart");
}

Cart.prototype.get = function(){
	return JSON.parse(localStorage.getItem('cart'));
}

/**
	Class ShoppingCartList
		Manager list product in header widget
**/
function ShoppingCartList(cart){
	//Singleton
	if ( arguments.callee._singletonInstance )
    	return arguments.callee._singletonInstance;
  	arguments.callee._singletonInstance = this;
	
	this.cart = cart;
}

ShoppingCartList.prototype.getProducts = function(){

	var out = "";
	for (i=0;i<this.cart.products.length;i++){
		out += "<li>\n";
		out += "\t<a>\n";
		out += "\t\t<b>"+myCart.products[i].title+"</b>\n";
		out += "\t\t<span>x"+myCart.products[i].cant+" $";
		out += myCart.products[i].stotal+"</span>\n";
		out += "\t</a>\n";
		out += "</li>\n"; 
	}
	out+="<li class=\"divider\"></li>";
	out+="<li><a href=\"cart.html\">Total: $"+this.cart.total+"</a></li>";
	return out;
}

ShoppingCartList.prototype.getCart = function(){ return this.cart; }


ShoppingCartList.prototype.update = function(){
	$('#cart-content').html(this.getProducts());
}

/**
	Class Product
	 The product item
**/
function Product(id,image,link,title,unit,stotal){

	self.id=id;
	self.image=image;
	self.link=link;
	self.title=title;
	self.unit=unit;
	self.stotal=stotal;
}

Product.prototype.get = function(){ return self }

/*
   actions of buttons
*/

$( document ).ready(function() {

	// init cart
	myCart = new Cart();
	// init shopping list
	myShoppingCartList =  new ShoppingCartList(myCart.get());

	//button action of the list product, for example home
	$( ".to-cart" ).click(function( event ) {
		//call for _id
		productId=$(this).attr("product-id")
		// url to ajax
		jsonUrl = "/design/get?json=True&identifier="+productId

		$.getJSON(jsonUrl,
			function( resp ) {
				// response object
				//id,image,link,title,unit,stotal
				cantidad = 100
				url = "/design/get?identifier="+productId

				//set a product
				myProduct = new Product(resp.id,
					resp.avatar,url,resp.title,cantidad,resp.costunit)

				//add to cart
				myCart.addProduct(myProduct.get());
				
    			//update a header shopping cart
    			myShoppingCartList.update();
			});
    });
});	


