//
//  LoginViewModel.swift
//  iosApp
//
//  Created by Chinthaka on 03/04/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared


class LoginViewModel{
    
    private let sharedViewModel: SharedViewModel = SharedViewModel()
    
    public func authenticateUser(user : String , pass : String, completion: @escaping (ScreenState)->()) {
        let user = User(username: user, password: pass)
        self.sharedViewModel.stateProvider.getUserAuthState(user: user) { (state : ScreenState) in
            completion(state)
        }
    }
    
  
}
