//
//  MenuItemView.swift
//  DemoSwiftUI
//
//  Created by Chinthaka on 28/03/2021.
//

import SwiftUI

struct MenuItemView: View {

   @Binding var show: Bool
   @State var showUpdate = false
    @State var showLogout: Int? = 0
  var  homeViewModel = HomeViewModel()

   var body: some View {
      return ZStack(alignment: .topTrailing) {
         HStack {
            NavigationLink(destination: LandingPage(), tag: 1, selection: $showLogout) {
            }
            Button(action: { self.showUpdate.toggle() }) {
                CircleButtonView(icon: "person.crop.circle")
                  .sheet(isPresented: self.$showUpdate) {
                    EditProfileView()
                  }
            }
            Button(action: {
                self.homeViewModel.clearToken()
                self.showLogout = 1
            }) {
                CircleButtonView(icon: "safari")
            }
           
         }
         Spacer()
      }
   }
}

