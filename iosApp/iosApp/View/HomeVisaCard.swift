//
//  HomeVisaCard.swift
//  DemoSwiftUI
//
//  Created by Chinthaka on 28/03/2021.
//

import SwiftUI
import shared

struct HomeVisaCard: View {
    
    var title = "RM 100.00"
    var image = "Illustration1"
    var color = Color("background3")
    var shadowColor = Color("backgroundShadow3")
    @State var fullName = ""
    var homeViewModel = HomeViewModel()
    
    var body: some View {
        return VStack(alignment: .leading) {
            ZStack{
                HStack{
                    VStack{
                        HStack{
                            VStack{
                                Text("RM 20.00").font(.title)
                                    .fontWeight(.heavy)
                                    .foregroundColor(.white)
                            }.padding(10)
                            .lineLimit(30)
                            
                            Spacer()
                            
                        }
                    }
                    Spacer()
                }
            }
            
            Spacer()
            
            HStack{
                Text(self.fullName).font(.subheadline)
                    .fontWeight(.bold)
                    .foregroundColor(.white)
                    .padding(10)
                    .lineLimit(30)
                Spacer()
                Image("visa")
                    .resizable()
                    .renderingMode(.original)
                    .aspectRatio(contentMode: .fit)
                    .frame(width: 60, height: 60)
                    .padding(.leading, 30)
                    .padding(.horizontal, 30)
                
            }.onAppear(perform: {
                self.homeViewModel.initHome(completion: { (state : HomeScreenState) in
                    self.fullName = state.fullName
                })
            })
        }
        .background(
            Color("bg_color"))
        .cornerRadius(10)
        .frame(width:UIScreen.main.bounds.width - 40,height:UIScreen.main.bounds.height / 4 )
        
        
        .shadow(color: shadowColor, radius: 20, x: 0, y: 20)
    }
}

struct HomeVisaCard_Previews: PreviewProvider {
    static var previews: some View {
        HomeVisaCard()
    }
}
