import mycycle.*
class BootStrap {
    def springSecurityService
    def init = { servletContext ->

        def adminRole = Role.findOrSaveWhere(authority:'ROLE_ADMIN')
        def user = User.findOrSaveWhere(username:'admin',password:'password')
//        def userRole=Role.findOrSaveWhere(authority: 'ROLE_USER')
//        def user2=Role.findOrSaveWhere(username:'user',password:'password')
        if(!user.authorities.contains(adminRole)){
            UserRole.create(user,adminRole,true)
        }
//        if(!user2.authorities.contains(userRole)){
//            UserRole.create(user2,userRole,true)
//        }

    }
    def destroy = {
    }
}
