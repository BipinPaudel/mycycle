package mycycle

class UserController {

    def index() {
        render "user index"
    }

    def form(){
        def roles=Role.list()
        println roles.getClass()
        //def roles = ['Admin':0,'User':1]
        [roles:roles]
    }

    def save(){


        def user=new User(params)
        print params
        if(user.save()){
            render "Successfully added user"
        }

        else{
            render "not added user"
        }
    }
}
