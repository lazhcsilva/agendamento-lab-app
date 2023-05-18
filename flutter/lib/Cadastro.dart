import 'package:agendamento/main.dart';
import 'package:flutter/material.dart';

import 'package:flutter/services.dart';

class Cadastro extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
        appBar: AppBar(
          backgroundColor: Colors.purple,
          toolbarHeight: 110,
          title: Text(
            'Uninassau',
            style: TextStyle(
              fontFamily: 'Anton',
              color: Colors.white,
            ),
          ),
          centerTitle: true,
        ),
        body: Center(
            child: Stack(
          children: [
            Column(
              mainAxisAlignment: MainAxisAlignment.spaceEvenly,
              children: [
                Padding(
                  padding: const EdgeInsets.all(16),
                  child: Form(
                    child: Center(
                      child: ListView(
                        shrinkWrap: true,
                        children: [
                          TextFormField(
                              decoration: const InputDecoration(
                                labelText: 'insira seu nome completo',
                                labelStyle: TextStyle(
                                    color: Colors.purple, fontSize: 20),
                                hintText: 'Insira seu nome',
                                hintStyle: TextStyle(color: Colors.purple),
                                counterText: '',
                                border: OutlineInputBorder(),
                              ),
                              maxLength: 10,
                              keyboardType: TextInputType.text,
                              validator: (text) {
                                if (text == null || text.isEmpty)
                                  return 'Campo obrigatório';
                              }),
                          const SizedBox(height: 16),
                          TextFormField(
                            decoration: const InputDecoration(
                                labelText: 'Insira sua Matrícula',
                                labelStyle: TextStyle(color: Colors.purple),
                                hintText: 'Insira sua Matrícula',
                                hintStyle: TextStyle(color: Colors.purple),
                                suffixText: 'Matrícula',
                                counterText: '',
                                border: OutlineInputBorder()),
                            maxLength: 10,
                            keyboardType: TextInputType.number,
                            validator: (text) {
                              if (text == null || text.isEmpty)
                                return 'Campo obrigatório';
                            },
                          ),
                          const SizedBox(height: 16),
                          TextFormField(
                            decoration: const InputDecoration(
                                labelText: 'Insira seu e-mail',
                                labelStyle: TextStyle(color: Colors.purple),
                                hintText: 'Insira seu e-mail',
                                hintStyle: TextStyle(color: Colors.purple),
                                suffixText: 'e-mail',
                                counterText: '',
                                border: OutlineInputBorder()),
                            maxLength: 10,
                            keyboardType: TextInputType.text,
                            validator: (text) {
                              if (text == null || text.isEmpty)
                                return 'Campo obrigatório';
                            },
                          ),
                          const SizedBox(height: 16),
                          TextFormField(
                            decoration: const InputDecoration(
                                labelText: 'Insira sua senha',
                                labelStyle: TextStyle(color: Colors.purple),
                                hintText: 'Insira sua senha',
                                hintStyle: TextStyle(color: Colors.purple),
                                suffixText: 'Senha',
                                counterText: '',
                                border: OutlineInputBorder()),
                            maxLength: 10,
                            keyboardType: TextInputType.number,
                            validator: (text) {
                              if (text == null || text.isEmpty)
                                return 'Campo obrigatório';
                            },
                          ),
                          const SizedBox(height: 16),
                          TextFormField(
                            decoration: const InputDecoration(
                                labelText: 'Insira sua senha novamente',
                                labelStyle: TextStyle(color: Colors.purple),
                                hintText: 'Insira sua senha',
                                hintStyle: TextStyle(color: Colors.purple),
                                suffixText: 'Senha',
                                counterText: '',
                                border: OutlineInputBorder()),
                            maxLength: 10,
                            keyboardType: TextInputType.number,
                            validator: (text) {
                              if (text == null || text.isEmpty)
                                return 'Campo obrigatório';
                            },
                          ),
                          const SizedBox(height: 16),
                          Padding(
                            padding: const EdgeInsets.fromLTRB(
                                128.0, 8.0, 128.0, 8.0),
                            child: ElevatedButton(
                              style: ElevatedButton.styleFrom(
                                  primary: Colors.purple),
                              onPressed: () {
                                Navigator.push(
                                  context,
                                  MaterialPageRoute(
                                    builder: (context) {
                                      return HomePage();
                                    },
                                  ),
                                );
                              },
                              child: Text(
                                'Cadastrar',
                                style: TextStyle(
                                    color: Colors.white, fontSize: 20),
                              ),
                            ),
                          ),
                        ],
                      ),
                    ),
                  ),
                ),
              ],
            ),
          ],
        )));
  }
}
