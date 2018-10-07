package com.example.demo.utils;

import java.lang.reflect.Field;

import com.example.demo.dto.Pessoa;
import com.example.demo.dto.ValidacaoPostException;

public class ValidacaoEntradaPost {

	public static boolean validaEntradaPost(Pessoa pessoa) throws Exception {
		Field[] fields = Pessoa.class.getDeclaredFields();

		for (Field field : fields) {
			field.setAccessible(true);
			String fieldValue = (String) field.getName();
			if (fieldValue.isEmpty() || fieldValue == null) {
				throw new ValidacaoPostException(String.format("Campo %s obrigatório", fieldValue));
			}
		}
		return true;
	}
}
