package automation


class AllInterceptor {

    public AllInterceptor(){
        // match all requests except requests
        // to the auth controller
        matchAll().excludes(controller: 'login')
    }

    boolean before() {
        if(!session.user) {
            redirect controller: 'login', action: 'index'
            return false
        }
        true
    }

    boolean after() { true }

    void afterView() {
        // no-op
    }
}
