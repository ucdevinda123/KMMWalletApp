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
        self.sharedViewModel.stateProvider.getUserProfileState(user: userProfile) { (state : UserProfileScreenState) in
            completion(state)
        }
    }
    
    func initProfile(completion: @escaping (UserProfileScreenState)->()){
        self.sharedViewModel.stateProvider.doInitProfileScreen { (state: UserProfileScreenState) in
            completion(state)
        }
    }
}
