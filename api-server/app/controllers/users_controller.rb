class UsersController < ApplicationController
  before_action :set_item, only: [:show, :update, :destroy]

  # GET /items
  def index
    @users = User.all

    render json: @users
  end

  # GET /items/1
  def show
    render json: @user
  end

  # POST /items
  def create
    @user = User.new(email: params[:email], name: params[:name], password: params[:password], address: params[:address], phone_number: params[:phone_number])

    if @user.save
      render json: @user, status: :created, location: @user
    else
      render json: @user.errors, status: :unprocessable_entity
    end
  end

  # PATCH/PUT /items/1
  def update
    if @user.update(email: params[:email], name: params[:name], password: params[:password], address: params[:address], phone_number: params[:phone_number])
      render json: @user
    else
      render json: @user.errors, status: :unprocessable_entity
    end
  end

  # DELETE /items/1
  def destroy
    @user.destroy
  end

  def show_by_email
    user = User.find_by(email: params[:email])
    render json: user
  end

  private
    # Use callbacks to share common setup or constraints between actions.
    def set_item
      @user = User.find(params[:id])
    end

    # Only allow a trusted parameter "white list" through.
    def item_params
      params.require(:item).permit(:name, :description)
    end
end
