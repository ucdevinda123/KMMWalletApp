import SwiftUI
import shared

func greet() -> String {
    return Greeting().greeting()
}

struct ContentView: View {
    var  loginViewModel = LoginViewModel()
    var body: some View {
       /*Try auto login  if(!loginViewModel.getToken().isEmpty){
            HomeView()
        }else {
            LandingPage()
        }*/
        LandingPage()
       
    }
}

struct ContentView_Previews: PreviewProvider {
    static var previews: some View {
        ContentView()
    }
}
