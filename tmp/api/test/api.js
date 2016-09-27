var express         = require("express"),
    app             = express(),
    bodyParser      = require("body-parser"),
    methodOverride  = require("method-override"),
    mongoose        = require('mongoose');

// Connection to DB
mongoose.connect('mongodb://localhost/test', function(err, res) {
  if(err) throw err;
  console.log('Connected to Database');
});

// Middlewares
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use(methodOverride());

// Import Models and controllers

    
var order_model = require('./models/order')(app, mongoose);
    
    
var order_controller = require('./controllers/orders');
    



// Example Route
var router = express.Router();
router.get('/', function(req, res) {
  res.send("Hello world!");
});
app.use(router);

// API routes
var test = express.Router();



test.route('/orders')
  .get(order_controller.findAllOrders)
  .post(order_controller.addOrder);


test.route('/orders/route/:route_id')
  .get(order_controller.findByRoute);


test.route('/order/:id')
  .get(order_controller.findById)
  .put(order_controller.updateOrder)
  .delete(order_controller.deleteOrder);




app.use('/api', test);

// Start server
app.listen(3003, function() {
  console.log("Node server running on http://localhost:3003");
});