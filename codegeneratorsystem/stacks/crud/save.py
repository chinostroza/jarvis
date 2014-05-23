	def Save(self,collection,_id):
		data = collection.find({{ criterio }})
		if data.count() >= 1:
			collection.update(
				{"_id" : data[0]["_id"]},
				{"$set" : {
					{% set i = 0 %}
					{% for key, value in setdata.items() %}
					"{{ key }}":{{ value }}{% if i != len(setdata)-1 %},{% end %}
					{% set i = i + 1 %}
					{% end %}
				}})
			return str(data[0]["_id"])
		#save the object and return the id
		object_id = collection.insert(
			{
				{% set i = 0 %}
				{% for key, value in setdata.items() %}
				"{{ key }}":{{ value }}{% if i != len(setdata)-1 %},{% end %}
				{% set i = i + 1 %}
				{% end %}
			})
		return str(object_id)