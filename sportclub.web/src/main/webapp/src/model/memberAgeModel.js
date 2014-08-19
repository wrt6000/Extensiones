define(['model/memberAgeModel'], function() {
//Aqu� se define la estructura de un �tem de la lista. Note que el modelo extiende el modelo est�ndar backbone.
    App.Model.MemberAgeModel = Backbone.Model.extend({
        defaults: {
         'name' : '',
         'age' : ''
        },
        getDisplay: function(name) {
         return this.get(name);
        }
        });
//Aqu� se define el modelo de la lista. El modelo de la lista extiende de Backbone.Collection. En el atributo �model� se define el modelo  (definido arriba) que corresponde al molde de cada uno de los �tems de la lista.
    App.Model.MemberAgeList = Backbone.Collection.extend({
        model: App.Model.MemberAgeModel
    });
    return  App.Model.MemberAgeModel;
});

