//
//  UserProfileViewModel.swift
//  iosApp
//
//  Created by Chinthaka on 05/04/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared


class UserProfileViewModel {
    private let sharedViewModel: SharedViewModel = SharedViewModel()
    
    public func editUserProfile(firstName : String,lastName:String ,completion: @escaping (UserProfileScreenState)->()) {
        let userProfile = UserProfile(firstName: firstName,lastName: lastName)
        self.sharedViewModel.events.updateUserProfile(id:getUserId(),token:getToken(),user: userProfile) { (state : UserProfileScreenState) in
            completion(state)
        }
    }
    
    func getUserId() -> String{
        return sharedViewModel.events.getId()
    }
    
    func getToken() -> String{
        return sharedViewModel.events.getToken()
    }
    
    func getUserFirstName() -> String{
        return sharedViewModel.events.getFirstName()
    }
    
    func getUserLastName() -> String{
        return sharedViewModel.events.getLastName()
    }
}



