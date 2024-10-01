//
//  RegisterView.swift
//  iosApp
//
//  Created by Natneal Asmelash on 9/21/24.
//  Copyright © 2024 orgName. All rights reserved.
//

import SwiftUI

struct RegisterView: View {
    @State var name = ""
    @State var email = ""
    @State var password = ""
    @State var phone = ""

    var body: some View {
        VStack{
            HeaderView(
                title: "Register",
                subtitle: "Start organizing today",
                angle: -12,
                background: .orange)
            
            Form{
                TextField("Full Name", text: $name)
                    .textFieldStyle(DefaultTextFieldStyle())
                    .autocorrectionDisabled()
                TextField("Email Address", text: $email)
                    .textFieldStyle(DefaultTextFieldStyle())
                    .autocorrectionDisabled()
                    .autocapitalization(.none)
                TextField("password", text: $password)
                    .textFieldStyle(DefaultTextFieldStyle())
                TextField("phone number", text: $phone)
                    .textFieldStyle(DefaultTextFieldStyle())
                Button{
                    //onclick register
                } label: {
                    ZStack{
                        RoundedRectangle(cornerRadius: 10)
                            .foregroundColor(Color.blue)
                        Text("Register")
                            .foregroundColor(Color.white)
                            .bold()
                    }
                }
            }
            Text("Create an account")
            .offset(y: -50)
            Spacer()
        }
    }
}

struct RegisterView_Preview: PreviewProvider{
    static var previews: some View {
        RegisterView()
    }
}
