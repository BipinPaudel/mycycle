package mycycle

class UserController {

    def index() {
        render "user index"
    }

    def form(){
        def role=Role.list()
        [role:role.title]
    }

    def save(){
        params.role=Role.findByTitle(params.role).id
        def user=new User(params)

        if(user.save(flush: true)){
            render "Successfully added user"
        }

        else{
            render "not added user"
        }
    }
}
