//File: controllers/orders.js
var mongoose = require('mongoose');
var Order  = mongoose.model('Order');

//GET - Return all orders in the DB
exports.findAllOrders = function(req, res) {
	Order.find(function(err, orders) {
    if(err) res.send(500, err.message);

    console.log('GET /orders')
		res.status(200).jsonp(orders);
	});
};

//GET - Return a Order with specified ID
exports.findById = function(req, res) {
	Order.findById(req.params.id, function(err, order) {
    if(err) return res.send(500, err.message);

    console.log('GET /order/' + req.params.id);
		res.status(200).jsonp(order);
	});
};

//POST - Insert a new order in the DB
exports.addOrder = function(req, res) {
	console.log('POST');
	console.log(req.body);

	var order = new Order ({
		id: req.body.id,route_id: req.body.route_id,order_id: req.body.order_id,code: req.body.code,status: req.body.status,position: req.body.position,created_ad: req.body.created_ad,updated_ad: req.body.updated_ad
	});

	order.save(function(err, order) {
		if(err) return res.send(500, err.message);
    res.status(200).jsonp(order);
	});
};

//PUT - Update a register already exists
exports.updateOrder = function(req, res) {
	Order.findById(req.params.id, function(err, order) {
		order.id= req.body.id;order.route_id= req.body.route_id;order.order_id= req.body.order_id;order.code= req.body.code;order.status= req.body.status;order.position= req.body.position;order.created_ad= req.body.created_ad;order.updated_ad= req.body.updated_ad;

		order.save(function(err) {
			if(err) return res.send(500, err.message);
      res.status(200).jsonp(order);
		});
	});
};

//DELETE - Delete a Order with specified ID
exports.deleteOrder = function(req, res) {
	Order.findById(req.params.id, function(err, order) {
		order.remove(function(err) {
			if(err) return res.send(500, err.message);
      res.status(200);
		})
	});
};