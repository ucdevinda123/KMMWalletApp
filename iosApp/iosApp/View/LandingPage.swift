//
//  LandingPage.swift
//  DemoSwiftUI
//
//  Created by Chinthaka on 28/03/2021.
//

import SwiftUI

struct LandingPage: View {
    @State private var action: Int? = 0
    @State private var actionSignUp: Int? = 0
    var body: some View {
        NavigationView {
            ZStack{
                
                Image("bg_landing").resizable()
                    .aspectRatio(contentMode: .fill)
                    .frame(width: UIScreen.main.bounds.width)
                    .overlay(Color.black.opacity(0.35)) .edgesIgnoringSafeArea([.top, .bottom])
                
                VStack(){
                    
                    VStack(alignment: .leading, spacing:30){
                        
                        Text("Spend like a local wherever you go!")
                            .font(.system(size: 35))
                            .fontWeight(.heavy)
                            .foregroundColor(.white)
                        
                        Text("Instantly change your ringgit into 11 different currencies (psst, more to come!) with zero hidden fees and real-time exchange rates.")
                            .fontWeight(.semibold)
                            .foregroundColor(.white)
                        
                        
                    }
                    
                    Spacer()
                    
                    VStack {
                        
                        HStack {
                            NavigationLink(destination: LoginView(), tag: 1, selection: $action) {
                                
                            }
                            Text("Sign In")
                                
                                .font(.system(size: 18))
                        }
                        .frame(width: UIScreen.main.bounds.width - 45, height: nil, alignment: .center)
                        .padding()
                        .foregroundColor(.white)
                        .overlay(
                            RoundedRectangle(cornerRadius: 45)
                                .stroke(Color.white, lineWidth: 2)
                        ).onTapGesture {
                            //perform some tasks if needed before opening Destination view
                            self.action = 1
                        }
                        
         
                        HStack {
                            NavigationLink(destination: SignUpView(), tag: 1, selection: $actionSignUp) {
                                
                            }
                            
                            Text("Sign Up")
                                .font(.system(size: 18))
                                .onTapGesture {
                                    //perform some tasks if needed before opening Destination view
                                    self.actionSignUp = 1
                                }
                        }
                        .frame(width: UIScreen.main.bounds.width - 45, height: nil, alignment: .center)
                        .padding()
                        .foregroundColor(.white)
                        
                        .background(RoundedRectangle(cornerRadius: 45).fill(Color("bg_color")))
                        
                    }
                   
                }
            }
        }.accentColor(.white).navigationBarHidden(true)
    }
    
}
struct LandingPage_Previews: PreviewProvider {
    static var previews: some View {
        LandingPage()
    }
}
