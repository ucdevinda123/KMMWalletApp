//
//  SignUpViewModel.swift
//  iosApp
//
//  Created by Chinthaka on 05/04/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared


class SignUpViewModel {
    private let sharedViewModel: SharedViewModel = SharedViewModel()
    
    public func signUpUser(firstName : String,lastName : String,mobile : String , pass:String, completion: @escaping (SignUpScreenState)->()) {
        let userRegistration = UserRegistration(username:mobile,password: pass,firstName: firstName,lastName: lastName)
        self.sharedViewModel.events.userSignUp(user: userRegistration) { (state : SignUpScreenState) in
            completion(state)
        }
    }
}
