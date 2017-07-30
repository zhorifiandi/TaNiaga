# encoding: UTF-8
# This file is auto-generated from the current state of the database. Instead
# of editing this file, please use the migrations feature of Active Record to
# incrementally modify your database, and then regenerate this schema definition.
#
# Note that this schema.rb definition is the authoritative source for your
# database schema. If you need to create the application database on another
# system, you should be using db:schema:load, not running all the migrations
# from scratch. The latter is a flawed and unsustainable approach (the more migrations
# you'll amass, the slower it'll run and the greater likelihood for issues).
#
# It's strongly recommended that you check this file into your version control system.

ActiveRecord::Schema.define(version: 20170730082309) do

  create_table "ar_internal_metadata", primary_key: "key", force: :cascade do |t|
    t.string   "value",      limit: 255
    t.datetime "created_at",             null: false
    t.datetime "updated_at",             null: false
  end

  create_table "farmers", force: :cascade do |t|
    t.string   "name",         limit: 255
    t.string   "phone_number", limit: 255
    t.integer  "seller_id",    limit: 4
    t.string   "array_item",   limit: 255
    t.datetime "created_at",               null: false
    t.datetime "updated_at",               null: false
  end

  create_table "incoming_messages", force: :cascade do |t|
    t.string   "agent_phone_number", limit: 255
    t.string   "from_number",        limit: 255
    t.string   "list_of_contents",   limit: 255
    t.datetime "created_at",                     null: false
    t.datetime "updated_at",                     null: false
  end

  create_table "items", force: :cascade do |t|
    t.string   "name",         limit: 255
    t.text     "description",  limit: 65535
    t.string   "category",     limit: 255
    t.integer  "price",        limit: 4
    t.string   "variety",      limit: 255
    t.string   "dimension",    limit: 255
    t.string   "seller_email", limit: 255
    t.datetime "created_at",                 null: false
    t.datetime "updated_at",                 null: false
  end

  create_table "outcoming_messages", force: :cascade do |t|
    t.string   "agent_phone_number", limit: 255
    t.string   "to_number",          limit: 255
    t.string   "list_of_contents",   limit: 255
    t.datetime "created_at",                     null: false
    t.datetime "updated_at",                     null: false
  end

  create_table "sellers", force: :cascade do |t|
    t.string   "name",         limit: 255
    t.string   "email",        limit: 255
    t.string   "address",      limit: 255
    t.string   "phone_number", limit: 255
    t.integer  "user_id",      limit: 4
    t.string   "array_farmer", limit: 255
    t.string   "array_item",   limit: 255
    t.datetime "created_at",               null: false
    t.datetime "updated_at",               null: false
  end

  create_table "sms", force: :cascade do |t|
    t.datetime "created_at", null: false
    t.datetime "updated_at", null: false
  end

  create_table "transactions", force: :cascade do |t|
    t.datetime "date"
    t.integer  "item_id",          limit: 4
    t.integer  "seller_id",        limit: 4
    t.integer  "buyer_id",         limit: 4
    t.string   "item_name",        limit: 255
    t.string   "seller_name",      limit: 255
    t.string   "buyer_name",       limit: 255
    t.integer  "amount_price",     limit: 4
    t.text     "description",      limit: 65535
    t.string   "transaction_code", limit: 255
    t.boolean  "ispaid"
    t.boolean  "issent"
    t.boolean  "isreceived"
    t.datetime "date_expired"
    t.datetime "created_at",                     null: false
    t.datetime "updated_at",                     null: false
  end

  create_table "users", force: :cascade do |t|
    t.string   "name",            limit: 255
    t.string   "email",           limit: 255
    t.string   "password_digest", limit: 255
    t.string   "address",         limit: 255
    t.string   "phone_number",    limit: 255
    t.datetime "created_at",                  null: false
    t.datetime "updated_at",                  null: false
  end

end
