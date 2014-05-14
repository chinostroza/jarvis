function WebStorage(item){
	this.item = item
}

WebStorage.prototype.save = function(data){
	//convert data to json fot to save
	localStorage.setItem(this.item, JSON.stringify(data));
}

WebStorage.prototype.del= function(){
	//del storage item
	localStorage.removeItem(this.item);
}

WebStorage.prototype.get= function(){
	return JSON.parse(localStorage.getItem(this.item));
}

WebStorage.prototype.exists= function(){
	if (localStorage.getItem(this.item)){
		return true;
	}else{
		return false;
	}
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

  	//TODO setting param constructor
  	this.db = new WebStorage('cart')
  	this.detailId = "cart-detail";
  	this.cartContentHeaderId = "cart-content";
  	this.checkoutCartContent="checkout-cart-content";
  	this.formCheckOut="form-checkout"

  	if(this.isCart()){
  		var cart = this.db.get();
  		var today = new Date();
		this.products = cart.products;
		this.date = today;
		this.user = cart.user;
		this.total = this.sumProducts();
		this.url = cart.url;
  	}else{
  		var today = new Date();
		this.products = [];
		this.date = today;
		this.user = "";
		this.total = 0.0;
  		this.url = "/cart";
  	}
}

Cart.prototype.sumProducts = function (){
	this.total = 0.0;
	products = this.products;

	for (i=0;i<products.length;i++){
		this.total += parseFloat(products[i].stotal)*parseFloat(products[i].unit);
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
	this.sumProducts()
	this.db.save(this)
}

Cart.prototype.del = function(){
	//del cart
	for(i=0;i<this.products.length;i++){
		this.delProduct(i);
	}

	this.db.del();
	
}

Cart.prototype.get = function(){
	//return cart object
	return this.db.get()
}
Cart.prototype.isCart = function(){
	//is cart exists
	return this.db.exists()
}
Cart.prototype.count = function(){
	return this.products.length
}
Cart.prototype.hola = function(){
	alert("Hola, soy el carro");
}
/**
	Class ShoppingCartList
		Manager list product in header widget and detail cart page
**/
function ShoppingCartList(){
	//Singleton
	if ( arguments.callee._singletonInstance )
    	return arguments.callee._singletonInstance;
  	arguments.callee._singletonInstance = this;
}

/*
 view function for header widget of the cart
*/
//TODO del param of the function, now is singleton myCart 
ShoppingCartList.prototype.getProductsHeader = function(cart){

	var out = "";
	for (i=0;i<cart.products.length;i++){
		out += "<li>\n";
		out += "\t<a>\n";
		out += "\t\t<b>"+cart.products[i].titulo+"</b>\n";
		out += "\t\t<span>x"+cart.products[i].unit+" $";
		out += parseFloat(cart.products[i].stotal).formatMoney(0, ',', '.')+"</span>\n";
		out += "\t</a>\n";
		out += "</li>\n";

	}
	out+="<li class=\"divider\"></li>";
	//Number.prototype.formatMoney = function(c, d, t)
	out+="<li><a href=\""+cart.url+"\">Total: $"+parseFloat(cart.total).formatMoney(0, ',', '.')+"</a></li>";
	return out;
}

ShoppingCartList.prototype.getCheckOutCartDetail = function(){
	
	var out="";
	for (i=0;i<myCart.products.length;i++){
		var stotal = parseFloat(myCart.products[i].stotal);
		var unit = parseFloat(myCart.products[i].unit);
		var subtotal = parseFloat(stotal*unit);
		var myString =[
			'<tr>',
			'<td>'+myCart.products[i].titulo+'</td>',
			'<td>M</td>',
			'<td>-</td>',
			'<td class="text-center">'+ parseFloat(myCart.products[i].unit)+'</td>',
			'<td class="price">$ '+parseFloat(myCart.products[i].stotal)+'</td>',
			'<td>$ '+subtotal.formatMoney(0, '','.')+'</td>',
			'<td class="text-center">',
			'<a href="javascript:myShoppingCartList.delProduct('+i+');" class="remove_cart" rel="2">',
			'<i class="fa fa-trash-o"></i>',
			'</a>',
			'</td>',
			'</tr>'
		].join("\n");
		out += myString
	}

	var myString =[
		'<tr>',
		'	<td colspan="5" align="right">Flat Shipping Rate</td>',
		'	<td class="total" colspan="2"><b>$ 5.00</b></td>',
		'</tr>',
		'<tr>',
		' 	<td colspan="5" align="right">Total</td>',
		'	<td class="total" colspan="2"><b>$ '+parseFloat(myCart.total).formatMoney(0, '','.')+'</b></td>',
		'</tr>'
	].join("\n");
	out += myString;
	return out;
}

ShoppingCartList.prototype.getProductsDetail = function(cart){
	
	var out = "";
	
	for (i=0;i<cart.products.length;i++){
		var stotal = parseFloat(cart.products[i].stotal);
		var unit = parseFloat(cart.products[i].unit);
		var subtotal = stotal*unit;
		var myString = 
			['<tr>',
			'<td class="hidden-xs">',
			'<a href="detail.html">',
			'<img src="'+cart.products[i].image+'" alt="" title="" width="47" height="47" />',
			'</a>',
			'</td>',
			'<td><a href="/design/get/'+cart.products[i].url+'">'+cart.products[i].titulo+'</a>',
			'</td>',
			'<td>',
			'<select name="">',
			'<option value="" selected="selected">S</option>',
			'<option value="">M</option>',
			'</select>',
			'</td>',
			'<td>-</td>',
			'<td>',
			'<input type="text" name="" value="'+cart.products[i].unit+'" class="input-qty form-control text-center" />',
			'</td>',
			'<td class="price">$ '+parseFloat(cart.products[i].stotal).formatMoney(0, ',', '.')+'</td>',
			'<td>$ '+(subtotal).formatMoney(0, ',','.')+'</td>',
			'<td class="text-center">',
			'<a href="javascript:myShoppingCartList.delProduct('+i+');" class="remove_cart" rel="2">',
			'<i class="fa fa-trash-o"></i>',
			'</a>',
			'</td>',
			' </tr>'
			].join("\n");
		out += myString;
	}
	var myString = [
	'<tr>',
	'<td colspan="6" align="right">Total</td>',
	'<td class="total" colspan="2">$'+parseFloat(cart.total).formatMoney(0, '','.')+'</td>',
	'</tr>'
	].join("\n")
	out += myString;
	return out;
}

ShoppingCartList.prototype.update = function(cart){
	if (cart){
		$('#'+cart.cartContentHeaderId).html(this.getProductsHeader(cart));
		//if we are in the product detail cart
		if (document.getElementById(cart.detailId)){
			$('#'+cart.detailId).html(this.getProductsDetail(cart));
		}
		if (document.getElementById(cart.checkoutCartContent)){
			$('#'+cart.checkoutCartContent).html(this.getCheckOutCartDetail());
		}
	}
}
ShoppingCartList.prototype.setCount = function(count){
	
	//remove this html tag
	$('#cart-count').html(count)
}

ShoppingCartList.prototype.delProduct = function(index){
	
	//del product of the cart
	myCart.delProduct(index);
	
	//update a header shopping cart
    this.update(myCart.get());

    // update count cart items
	this.setCount(myCart.count())

}

/**
	Class Product
	 The product item
**/
function Product(identificador,image,link,title,unit,stotal){

	this.identificador=identificador;
	this.image=image;
	this.url=link;
	this.titulo=title;
	this.unit=unit;
	this.stotal=stotal;
}

Product.prototype.get = function(){ return this }

/**
	Class CheckOut
**/

function CheckOut(){

}

CheckOut.prototype.confirm = function () {
	
	//send data
	var formObje=document.getElementById(myCart.formCheckOut);
	
	//TODO validar
	var param = $( "#" + myCart.formCheckOut ).serialize();
	param += "&cart="+JSON.stringify(myCart.get());

	//Post ajax request	
	$.ajax({
		  type: "POST",
		  url: formObje.action,
		  data: param,
		  success: function( data ) {
    			//TODO generar mensaje de retorno
    			alert( "Compra OK" );
    			myCart.del();
    		}
		});
	
	return false;
}

/*
   actions of buttons
*/

$( document ).ready(function() {

	// init cart
	myCart = new Cart();

	// init shopping list
	myShoppingCartList =  new ShoppingCartList();

	// init CheckOut
	myCheckOut = new CheckOut();
	
	//update a header shopping cart
	myShoppingCartList.update(myCart.get());

	// update count cart items
	myShoppingCartList.setCount(myCart.count())

	//button action of the list product, for example home
	$( ".to-cart" ).click(function( event ) {
		//call for _id
		productId=$(this).attr("product-id")
		//url to ajax
		jsonUrl = "/design/get?json=True&identifier="+productId

		$.getJSON(jsonUrl,
			function( resp ) {
				// response object
				//id,image,link,title,unit,stotal
				cantidad = 100
				url = "/design/get?identifier="+productId

				//set a product
				myProduct = new Product(resp._id["\$oid"],
					resp.avatar,url,resp.title,cantidad,resp.costunit)

				//add to cart
				myCart.addProduct(myProduct.get());

    			//update a header shopping cart
    			myShoppingCartList.update(myCart.get());

    			// update count cart items
				myShoppingCartList.setCount(myCart.count())

				//
				alert( "Producto agregado al carro" );
			});
    });
});	


