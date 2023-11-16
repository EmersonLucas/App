package br.com.project.moonlight.utils;

import androidx.annotation.NonNull;

public enum EnumElements {

    MSG_VALUES_NULL{
        @NonNull
        @Override
        public String toString() {
            return "Nenhum campo pode esta vazio.";
        }
    },
    MSG_PASS_INVALID{
        @NonNull
        @Override
        public String toString() {
            return "Senha não pode conter menos que 6 caracteres.";
        }
    },
    MSG_EMAIL_INVALID{
        @NonNull
        @Override
        public String toString() {
            return "Email invalido.";
        }
    },
    MSG_EMAIL_USED{
        @NonNull
        @Override
        public String toString() {
            return "Email já utilizado.";
        }
    },
    MSG_REGISTER_SUCCESSFUL{
        @NonNull
        @Override
        public String toString() {
            return "Cadastrado com sucesso.";
        }
    },
    MSG_CREDENC_INVALID{
        @NonNull
        @Override
        public String toString() {
            return "Email ou senha invalido.";
        }
    }
}
