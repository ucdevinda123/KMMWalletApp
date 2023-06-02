//
//  HomeView.swift
//  DemoSwiftUI
//
//  Created by Chinthaka on 25/03/2021.
//

import SwiftUI
import shared
let window = UIApplication.shared.windows.filter {$0.isKeyWindow}.first
let statusBarHeight = window?.windowScene?.statusBarManager?.statusBarFrame.height ?? 0
let screen = UIScreen.main.bounds

struct HomeView: View {
    @State private var actionHome: Int? = 0
    @State var show = false
    @State var showProfile = false
    @State var name = ""
    @State var welcomeMessage = ""
    var homeViewModel = HomeViewModel()
    
    var body: some View {
        
        return ZStack{
            VStack{
                HStack(alignment: .top) {
                    VStack(alignment: .leading) {
                        Text(self.name)
                            .font(.largeTitle)
                            .fontWeight(.heavy)
                        Text(self.welcomeMessage)
                            .foregroundColor(.gray)
                    }.offset(x: 12).onAppear(perform: {
                        homeViewModel.initHome(completion: { (state : HomeScreenState) in
                            self.name = state.name
                            self.welcomeMessage = state.greeting
                        })
                        
                    })
                    Spacer()
                    
                    MenuItemView(show: $showProfile)
                        .offset(x: -16)
                }.padding(.all) .offset(y: 20)
                HomeVisaCard()
                
                HStack{
                    CardButtonView(icon: "transfer",title:"Transfer")
                    CardButtonView(icon: "lock_card",title:"Lock Card")
                    CardButtonView(icon: "pl",title:"Top up")
                }.padding(.all)
                
                CardBottomView()
                
            }
        }.frame(width: UIScreen.main.bounds.width, height: UIScreen.main.bounds.height).background(Color("background")).navigationBarHidden(true)
        .navigationBarTitle(Text("Home"))
        .edgesIgnoringSafeArea([.top, .bottom])
    }
}

struct HomeView_Previews: PreviewProvider {
    static var previews: some View {
        HomeView()
    }
}


struct CardBottomView: View {
    var body: some View {
        return ZStack{
            VStack(spacing: 20.0) {
                Rectangle()
                    .frame(width: 60, height: 6)
                    .cornerRadius(3.0)
                    .opacity(0.1)
                
                HStack {
                    
                    Text("Last Trasnsactions")
                        .font(.caption)
                        .fontWeight(.bold)
                    Spacer()
                    Text("See All")
                        .font(.caption)
                        .fontWeight(.bold)
                        .foregroundColor(.gray)
                    
                }
                
                TransactionItemView(image: "spotify", title: "Transaction", price: 11.99 , date: "10 Oct, 8:25 AM")
                
                TransactionItemView(image: "xbox", title: "XBox Purchase", price: 11.99 , date: "10 Oct, 8:25 AM")
                TransactionItemView(image: "spotify", title: "Transaction", price: 11.99 , date: "10 Oct, 8:25 AM")
                TransactionItemView(image: "spotify", title: "Transaction", price: 11.99 , date: "10 Oct, 8:25 AM")
                TransactionItemView(image: "spotify", title: "Transaction", price: 11.99 , date: "10 Oct, 8:25 AM")
            }
            .frame(minWidth: 0, maxWidth: .infinity, minHeight: 300)
            .padding()
            .padding(.horizontal)
            .background(Color.white)
            .cornerRadius(30)
            .shadow(radius: 20)
        }
        
    }
}
