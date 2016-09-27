exports = module.exports = function(app, mongoose) {

	var itemSchema = new mongoose.Schema({
		id: { type:Number},order_id: { type:Number},code: { type:String},title: { type:String},quantity: { type:Number},status: { type:Number},created_ad: { type:Date},updated_ad: { type:Date}
	});

	mongoose.model('Item', itemSchema);

};