package com.example.demo.controller;

import org.apache.camel.Exchange;

import com.example.demo.dto.Pessoa;
import com.example.demo.utils.ValidacaoEntradaPost;

public class PessoaController {

	public void trataEntradaPost(Exchange exchange) throws Exception {
		Pessoa pessoa = exchange.getIn().getBody(Pessoa.class);
		if (ValidacaoEntradaPost.validaEntradaPost(pessoa)) {
			exchange.getIn().setBody(pessoa);
		}
	}
}
