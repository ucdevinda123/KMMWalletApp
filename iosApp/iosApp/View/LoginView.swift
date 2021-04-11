//
//  LoginView.swift
//  DemoSwiftUI
//
//  Created by Chinthaka on 28/03/2021.
//

import SwiftUI
import shared

struct LoginView: View {
    @State private var mobileNo = ""
    @State private var password = ""
    @State private var actionHome: Int? = 0
    @State private var loginState = ScreenState(status: Status.loading, message: "")
    @State private var signInBtnLabel = "SignIn"
    @State var showsAlert = false
    @State var validationMessage = ""
    var  loginViewModel = LoginViewModel()
    
    init() {
        self.loginState =  ScreenState(status: Status.loading, message: "")
        self.loginViewModel =  LoginViewModel()
    }
    
    private var validated: Bool {
        !self.mobileNo.isEmpty && !self.password.isEmpty
    }
    
    var body: some View {
        
        ZStack{
            
            Image("bg_landing").resizable()
                .aspectRatio(contentMode: .fill)
                .frame(width: UIScreen.main.bounds.width)
                .overlay(Color.black.opacity(0.35))
                .edgesIgnoringSafeArea([.top, .bottom])
            VStack(){
                
                Text("Welcome black!")
                    .font(.largeTitle)
                    .fontWeight(.heavy)
                    .foregroundColor(.white)
                    .frame(maxWidth: .infinity, alignment: .leading)
                    .padding(.leading)
                Text("Let's enter your details to Sign in")
                    .foregroundColor(.white)
                    .frame(maxWidth: .infinity, alignment: .leading)
                    .padding(.leading)
                Spacer()
            }
            
            Spacer()
            VStack(spacing:25){
                TextField("Mobile number",
                          text: self.$mobileNo)
                    .foregroundColor(.white)
                    .accentColor(Color.white)
                    .padding(.all)
                    .padding(.leading)
                    .padding(.trailing)
                    .cornerRadius(20.0)
                    .overlay(
                        RoundedRectangle(cornerRadius: 15)
                            .stroke(Color.white, lineWidth: 1)
                    ).frame(width: UIScreen.main.bounds.width - 25, height: nil, alignment: .center)
                
                SecureField("Password",
                            text: self.$password)
                    .foregroundColor(.white)
                    .accentColor(Color.white)
                    .padding(.all)
                    .padding(.leading)
                    .padding(.trailing)
                    .cornerRadius(20.0)
                    .overlay(
                        RoundedRectangle(cornerRadius: 15)
                            .stroke(Color.white, lineWidth: 1)
                    ).frame(width: UIScreen.main.bounds.width - 25, height: nil, alignment: .center)
                
                
                HStack {
                    NavigationLink(destination: HomeView(), tag: 1, selection: $actionHome) {
                    }
                    Text(self.signInBtnLabel)
                        .font(.system(size: 18))
                        .onTapGesture {
                            //perform some tasks if needed before opening Destination view
                            if validated {
                                self.showsAlert = false
                                self.signInBtnLabel = "Loading.."
                                loginViewModel.authenticateUser(user:self.mobileNo, pass: self.password, completion: { (state : ScreenState) in
                                    self.signInBtnLabel = "Sign In"
                                    if(state.status == Status.success){
                                        self.showsAlert = false
                                        self.actionHome = 1
                                    }else {
                                        self.validationMessage = state.message
                                        self.showsAlert = true
                                    }
                                }
                                )
                            }else{
                                self.validationMessage = "Empty fiedls are not allowed!"
                                self.showsAlert = true
                            }
                        }.alert(isPresented: self.$showsAlert, content: {
                            Alert(title: Text("Validation"), message: Text(self.validationMessage), dismissButton: .default(Text("Got it")))
                        })
                    
                }
                .frame(width: UIScreen.main.bounds.width - 45, height: nil, alignment: .center)
                .padding()
                .foregroundColor(.white)
                .background(RoundedRectangle(cornerRadius: 45).fill(Color("bg_color")))
                
            }
        }
    }
}

struct LoginView_Previews: PreviewProvider {
    static var previews: some View {
        LoginView()
    }
}
