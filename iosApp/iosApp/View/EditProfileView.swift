//
//  EditProfileView.swift
//  DemoSwiftUI
//
//  Created by Chinthaka on 28/03/2021.
//

import SwiftUI
import shared

struct EditProfileView: View {
    
    @State private var firstName = ""
    @State private var lastName = ""
    @State private var actionClose : Int? = 1
    @State var showsAlert = false
    @State var validationMessage = ""
    @State var editBtnLabel = "Update"
    var  userProfileViewModel = UserProfileViewModel()
    
    private var validated: Bool {
        !self.firstName.isEmpty && !self.lastName.isEmpty
    }
    
    init() {
        self.firstName = userProfileViewModel.getUserFirstName()
        self.lastName = userProfileViewModel.getUserLastName()
    }
    
    var body: some View {
        VStack {
            HStack() {
                Text("Edit Profile")
                    .font(.largeTitle)
                    .fontWeight(.heavy)
                    .padding(10)
                    .foregroundColor(.black)
                
            }
            Image("profile_edit_bg")
            
            VStack(alignment: .leading, spacing: 30) {
          
                TextField("First Name",
                          text: self.$firstName)
                    .foregroundColor(.black)
                    .accentColor(Color.black)
                    .padding(.all)
                    .padding(.leading)
                    .padding(.trailing)
                    .cornerRadius(20.0)
                    .overlay(
                        RoundedRectangle(cornerRadius: 15)
                            .stroke(Color.black, lineWidth: 1)
                    ).frame(width: UIScreen.main.bounds.width - 25, height: nil, alignment: .center)
                
                TextField("Last Name",
                          text: self.$lastName)
                    .foregroundColor(.black)
                    .accentColor(Color.black)
                    .padding(.all)
                    .padding(.leading)
                    .padding(.trailing)
                    .cornerRadius(20.0)
                    .overlay(
                        RoundedRectangle(cornerRadius: 15)
                            .stroke(Color.black, lineWidth: 1)
                    ).frame(width: UIScreen.main.bounds.width - 25, height: nil, alignment: .center)
                
                HStack {
                    NavigationLink(destination: HomeView(), tag: 1, selection: $actionClose) {
                    }
                    Text(self.editBtnLabel)
                        .font(.system(size: 18))
                        .onTapGesture {
                            //perform some tasks if needed before opening Destination view
                            if validated {
                                self.editBtnLabel = "Loading.."
                                userProfileViewModel.editUserProfile(firstName : self.firstName, lastName: self.lastName, completion: { (state: UserProfileScreenState) in
                                    self.editBtnLabel = "Update"
                                    self.validationMessage = state.message
                                    self.showsAlert = true
                                    if(state.status == Status.success){
                                        self.actionClose = 1
                                    }
                                })
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
            }.padding([.leading, .trailing], 27.5)
            
        }.frame(width: UIScreen.main.bounds.width, height: UIScreen.main.bounds.height).background(Color("background"))
    }
}

struct EditProfileView_Previews: PreviewProvider {
    static var previews: some View {
        EditProfileView()
    }
}
