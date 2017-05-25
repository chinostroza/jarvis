var express         = require("express"),
    app             = express(),
    bodyParser      = require("body-parser"),
    methodOverride  = require("method-override"),
    mongoose        = require('mongoose');

// Connection to DB
mongoose.connect('mongodb://localhost/{{ api.dbname }}', function(err, res) {
  if(err) throw err;
  console.log('Connected to Database');
});

// Middlewares
app.use(bodyParser.urlencoded({ extended: false }));
app.use(bodyParser.json());
app.use(methodOverride());

// Import Models and controllers
{% for  object in objects %}
var {{ object.name }}_model = require('./models/{{ object.name }}')(app, mongoose);
{% endfor %}
{% for  object in objects %}
var {{ object.name }}_controller = require('./controllers/{{ object.name }}');
{% endfor %}

// Example Route
var router = express.Router();
router.get('/', function(req, res) {
  res.send("Hello world!");
});
app.use(router);

// API routes
var {{ app.name }} = express.Router();

{% for  object in objects %}

{{ app.name }}.route('/{{ object.name }}')
  .get({{ object.name }}_controller.findAll{{ object.name|capitalize }}s)
  .post({{ object.name }}_controller.add{{ object.name|capitalize }});

{% endfor %}

{% for  object in objects %}

{{ app.name }}.route('/{{ object.name }}/:id')
  .get({{ object.name }}_controller.findById)
  .put({{ object.name }}_controller.update{{ object.name|capitalize }})
  .delete({{ object.name }}_controller.delete{{ object.name|capitalize }});

{% endfor %}

app.use('/api', {{ app.name }});

// Start server
app.listen({{ api.port }}, function() {
  console.log("Node server running on http://localhost:{{ api.port }}");
});