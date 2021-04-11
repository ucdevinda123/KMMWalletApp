//
//  HomeViewModel.swift
//  iosApp
//
//  Created by Chinthaka on 05/04/2021.
//  Copyright © 2021 orgName. All rights reserved.
//

import Foundation
import shared

class HomeViewModel {
    private let sharedViewModel: SharedViewModel = SharedViewModel()
    private func greetUser() -> String{
        
        let date = NSDate()
        let calendar = NSCalendar.current
        let currentHour = calendar.component(.hour, from: date as Date)
        let hourInt = Int(currentHour.description)!
        
        if hourInt >= 12 && hourInt <= 16 {
            return  "Good Afternoon"
        }
        else if (hourInt >= 7 && hourInt <= 12) || (hourInt >= 0 && hourInt <= 7)  {
            return "Good Morning"
        }
        else if hourInt >= 16 && hourInt <= 20 {
            return "Good Evening"
        }
        else if hourInt >= 20 && hourInt <= 24 {
            return "Good Night"
        }
        return ""
    }
    
    func initHome(completion: @escaping (HomeScreenState)->()){
        self.sharedViewModel.stateProvider.doInitHomeScreen { (state: HomeScreenState) in
            state.greeting = self.greetUser()
            completion(state)
        }
    }
}
