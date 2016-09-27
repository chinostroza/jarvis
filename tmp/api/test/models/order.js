exports = module.exports = function(app, mongoose) {

	var orderSchema = new mongoose.Schema({
		id: { type:Number},route_id: { type:Number},order_id: { type:Number},code: { type:String},status: { type:Number},position: { type:Number},created_ad: { type:Date},updated_ad: { type:Date}
	});

	mongoose.model('Order', orderSchema);

};