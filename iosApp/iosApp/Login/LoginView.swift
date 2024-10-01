//
//  LoginView.swift
//  iosApp
//
//  Created by Natneal Asmelash on 9/21/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct LoginView: View {
    
    @State var email = ""
    @State var password = ""

    var body: some View {
        NavigationView{
            VStack{
                //Header
                HeaderView(
                    title: "The Calendar App",
                    subtitle: "Plan & organize your life",
                    angle: 12,
                    background: .pink)
                
                //Form
                Form{
//                    if !viewModel.errorMessage.isEmpty{
//                        Text(viewModel.errorMessage)
//                            .foregroundColor(Color.red)
//                    }
                    TextField("Email Address", text: $email)
                        .textFieldStyle(RoundedBorderTextFieldStyle())
                        .autocapitalization(.none)
                    SecureField("Password", text: $password)
                        .textFieldStyle(RoundedBorderTextFieldStyle())
                    Button{
                        //onclick login
//                        viewModel.login()
                    } label: {
                        ZStack{
                            RoundedRectangle(cornerRadius: 10)
                                .foregroundColor(Color.blue)
                            Text("Log In")
                                .foregroundColor(Color.white)
                                .bold()
                        }
                    }
                    .padding()
                }
                .offset(y: -50)
                VStack {
                    Text("Create an Account")
                    NavigationLink(
                        "Register",
                        destination: RegisterView())
                }
                Spacer()
            }
        }
    }
}

#Preview {
    LoginView()
}
