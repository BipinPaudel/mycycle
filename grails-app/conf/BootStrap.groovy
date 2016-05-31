import mycycle.*
class BootStrap {
    def springSecurityService
    def init = { servletContext ->

        def adminRole = Role.findOrSaveWhere(authority:'ROLE_ADMIN')
        def user = User.findOrSaveWhere(username:'admin',password:'password')

        if(!user.authorities.contains(adminRole)){
            UserRole.create(user,adminRole,true)
        }
    }
    def destroy = {
    }
}
