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
    
    public func signUpUser(firstName : String,lastName : String,mobile : String , pass:String, completion: @escaping (ScreenState)->()) {
        let userRegistration = UserRegistration(username:mobile,password: pass,firstName: firstName,lastName: lastName)
        self.sharedViewModel.stateProvider.getUserRegistrationState(user: userRegistration) { (state : ScreenState) in
            completion(state)
        }
    }
}
