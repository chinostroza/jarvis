//File: controllers/items.js
var mongoose = require('mongoose');
var Item  = mongoose.model('Item');

//GET - Return all items in the DB
exports.findAllItems = function(req, res) {
	Item.find(function(err, items) {
    if(err) res.send(500, err.message);

    console.log('GET /items')
		res.status(200).jsonp(items);
	});
};

//GET - Return a Item with specified ID
exports.findById = function(req, res) {
	Item.findById(req.params.id, function(err, item) {
    if(err) return res.send(500, err.message);

    console.log('GET /item/' + req.params.id);
		res.status(200).jsonp(item);
	});
};
exports.findByOrder = function (req, res){
	Item.find({ "item_id": req.params.item_id }, function (err, items) {
	
		if(err) return res.send(500, err.message);

     	console.log('GET /items/order/' + req.params.order_id);

     	outItems = [];

     	items.forEach(function(element,index,array){

     		var mItem = {
     			"id":element.id,
     			"order_id" : element.order_id,
     			"code" : element.code,
     			"title" : element.title,
     			"quantity":element.quantity,
     			"status":element.status
     		}

     		outItems.push(mItem);

     	});

     	var itemsResponse = {
     		"name":"test Items",
     		"items":outItems
     	}

		res.status(200).jsonp(itemsResponse);
	});
};

//POST - Insert a new item in the DB
exports.addItem = function(req, res) {
	console.log('POST');
	console.log(req.body);

	var item = new Item ({
		id: req.body.id,order_id: req.body.order_id,code: req.body.code,title: req.body.title,quantity: req.body.quantity,status: req.body.status,created_ad: req.body.created_ad,updated_ad: req.body.updated_ad
	});

	item.save(function(err, item) {
		if(err) return res.send(500, err.message);
    res.status(200).jsonp(item);
	});
};

//PUT - Update a register already exists
exports.updateItem = function(req, res) {
	Item.findById(req.params.id, function(err, item) {
		item.id= req.body.id;item.order_id= req.body.order_id;item.code= req.body.code;item.title= req.body.title;item.quantity= req.body.quantity;item.status= req.body.status;item.created_ad= req.body.created_ad;item.updated_ad= req.body.updated_ad;

		item.save(function(err) {
			if(err) return res.send(500, err.message);
      res.status(200).jsonp(item);
		});
	});
};

//DELETE - Delete a Item with specified ID
exports.deleteItem = function(req, res) {
	Item.findById(req.params.id, function(err, item) {
		item.remove(function(err) {
			if(err) return res.send(500, err.message);
      res.status(200);
		})
	});
};