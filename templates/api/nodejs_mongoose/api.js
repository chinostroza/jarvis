var express         = require("express"),
    app             = express(),
    bodyParser      = require("body-parser"),
    methodOverride  = require("method-override"),
    mongoose        = require('mongoose');

// Connection to DB
mongoose.connect('mongodb://localhost/{{ dbname }}', function(err, res) {
  if(err) throw err;
  console.log('Connected to Database');
});

// Middlewares
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use(methodOverride());

// Import Models and controllers

    {% for  model in models %}
var {{ model }}_model = require('./models/{{ model }}')(app, mongoose);
    {% endfor %}
    {% for  controller in controllers %}
var {{ controller }}_controller = require('./controllers/{{ controller }}s');
    {% endfor %}



// Example Route
var router = express.Router();
router.get('/', function(req, res) {
  res.send("Hello world!");
});
app.use(router);

// API routes
var {{ nameapp }} = express.Router();

{% for  controller in controllers %}

{{ nameapp }}.route('/{{ controller }}s')
  .get({{ controller }}_controller.findAll{{ controller|capitalize }}s)
  .post({{ controller }}_controller.add{{ controller|capitalize }});

{% endfor %}

{% for  controller in controllers %}

{{ nameapp }}.route('/{{ controller }}/:id')
  .get({{ controller }}_controller.findById)
  .put({{ controller }}_controller.update{{ controller|capitalize }})
  .delete({{ controller }}_controller.delete{{ controller|capitalize }});

{% endfor %}

app.use('/api', {{ nameapp }});

// Start server
app.listen({{ port }}, function() {
  console.log("Node server running on http://localhost:{{ port }}");
});