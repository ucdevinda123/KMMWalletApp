//
//  SignUpView.swift
//  DemoSwiftUI
//
//  Created by Chinthaka on 28/03/2021.
//

import SwiftUI
import shared

struct SignUpView: View {
    @State private var firstName = ""
    @State private var lastName = ""
    @State private var mobileNo = ""
    @State private var password = ""
    @State private var rePassword = ""
    @State private var actionLogin: Int? = 0
    @State private var signUpState = SignUpScreenState(status: Status.loading, message: "")
    @State private var signInBtnLabel = "Sign Up"
    @State var showsAlert = false
    @State var validationMessage = ""
    var  signUpViewModel = SignUpViewModel()
    
    private var validated: Bool {
        !self.mobileNo.isEmpty && !self.password.isEmpty && !self.firstName.isEmpty && !self.lastName.isEmpty
    }
    
    private var isPasswordFieldsValidated: Bool {
        self.password == self.rePassword
    }
    
    var body: some View {
        
        ZStack{        
            Image("bg_landing").resizable()
                .aspectRatio(contentMode: .fill)
                .frame(width: UIScreen.main.bounds.width)
                .overlay(Color.black.opacity(0.35))
                .edgesIgnoringSafeArea([.top, .bottom])
            VStack(spacing:25){
                
                Text("Create Account")
                    .font(.largeTitle)
                    .fontWeight(.heavy)
                    .foregroundColor(.white)
                    .frame(maxWidth: .infinity, alignment: .leading)
                    .padding()
                Spacer()
            }
            
            Spacer()
            VStack(spacing:25){
                
                TextField("First Name",
                          text: self.$firstName)
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
                TextField("Last Name",
                          text: self.$lastName)
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
                TextField("Mobile No",
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
                
                SecureField("Re-Password",
                            text: self.$rePassword)
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
                    NavigationLink(destination: LoginView(), tag: 1, selection: $actionLogin) {
                    }
                    
                    Text("Sign Up")
                        .font(.system(size: 18))
                        .onTapGesture {
                            //perform some tasks if needed before opening Destination view
                            if validated {
                                if isPasswordFieldsValidated {
                                    self.signInBtnLabel = "Loading.."
                                    signUpViewModel.signUpUser(firstName : self.firstName, lastName: self.lastName,mobile:self.mobileNo,pass: self.password, completion: { (state : SignUpScreenState) in
                                        self.signInBtnLabel = "Sign Up"
                                        if(state.status == Status.success){
                                            self.showsAlert = false
                                            self.actionLogin = 1
                                        }else {
                                            self.validationMessage = state.message
                                            self.showsAlert = true
                                        }
                                    })
                                }else{
                                    self.validationMessage = "Please check your password!"
                                    self.showsAlert = true
                                }
                            }else {
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

struct SignUpView_Previews: PreviewProvider {
    static var previews: some View {
        SignUpView()
    }
}
