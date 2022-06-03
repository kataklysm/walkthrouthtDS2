package com.daveapps.walkthrouthds2


data class ItemsModalLocations (
        var location:String,
        var nextLocation:String,
        var bosess:String,
        var bonfires:String,
        var image:Int
)
data class ItemsModalBosses(
        var boss:String,
        var hp:String,
        var weakness:String,
        var resistance:String,
        var image:Int,
)

class ItemsModalCovenants(covenants: String, image: Int){
    var covenants: String? = covenants
    var image: Int? = image
}

class Modal(item: String, image: Int) {

    var item: String? = item
    var image: Int? = image

}
class ModalEnemies(name: String, image: Int) {
    var name: String? = name
    var image: Int? = image

}