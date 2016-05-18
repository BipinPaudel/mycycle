package mycycle

class RoleController {

    def index() {}

    def form(){

    }

    def save(){
        def role=new Role(params)
        if(role.save()){
            render "Yes"
        }
        else{
            render "No way"
        }
    }
}
