# This file should contain all the record creation needed to seed the database with its default values.
# The data can then be loaded with the rails db:seed command (or created alongside the database with db:setup).
#
# Examples:
#
#   movies = Movie.create([{ name: 'Star Wars' }, { name: 'Lord of the Rings' }])
#   Character.create(name: 'Luke', movie: movies.first)


User.create(email: "arizho16@gmail.com", name: "Ari Pratama Zhorifiandi", password: "akusedihdiputusin", address: "Masih disini setia menunggu", phone_number: "081380388254")
User.create(email: "wiegasonora@gmail.com", name: "Wiega", password: "lelahjomblo", address: "Godean Highgarden", phone_number: "081234567891")


Item.create(name: "Jagung Kuning Langsat",
            description: "Rasa sangat gurih",
            price: 40000)

Transaction.create(item_id: 1, seller_id: 1, buyer_id: 2, amount_price: 100000)
