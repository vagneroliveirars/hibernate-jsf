<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="f"  uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h"  uri="http://java.sun.com/jsf/html"%>
<%@ taglib prefix="t"  uri="http://myfaces.apache.org/tomahawk"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>Funcionario</title>
	</head>
	<body>
		<f:view>
			<h:form>
				Nome:
				<h:inputText id="nome" required="true" value="#{FuncionarioHandler.funcionario.nome}">
					<f:validateLength minimum="5"/>
				</h:inputText>
				<h:message for="nome"/><br/>
				Usuario:
				<h:inputText value="#{FuncionarioHandler.funcionario.usuario}"/><br/>
				Senha:
				<h:inputSecret value="#{FuncionarioHandler.funcionario.senha}"/><br/>
				Email:
				<h:inputText id="email" required="true" value="#{FuncionarioHandler.funcionario.email}" validator="#{FuncionarioHandler.validaEmail}"/>
				<h:message for="email"/><br/>
				Idade:
				<h:inputText value="#{FuncionarioHandler.funcionario.idade}"/><br/>
				<h:commandButton value="Salvar" action="#{FuncionarioHandler.salva}"/>				
			</h:form>
			
			<h:form>
				<h:dataTable id="funcionariosTable" rendered="#{not empty FuncionarioHandler.funcionarios}" border="1" var="f" value="#{FuncionarioHandler.funcionarios}" rows="5">
					<h:column>
						<f:facet name="header">
							<h:outputText value="Id"/>
						</f:facet>
						<h:outputText value="#{f.id}"/>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="Nome"/>	
						</f:facet>
						<h:outputText value="#{f.nome}"/>
					</h:column>	
					<h:column>
						<f:facet name="header">
							<h:outputText value="Usuario"/>	
						</f:facet>
						<h:outputText value="#{f.usuario}"/>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="Email"/>	
						</f:facet>
						<h:outputText value="#{f.email}"/>
					</h:column>
					<h:column>
						<f:facet name="header">
							<h:outputText value="Alterar"/>
						</f:facet>
						<h:commandButton value="Alterar" action="#{FuncionarioHandler.selecionaFuncionario}"/>
					</h:column>
				</h:dataTable>
				<t:dataScroller for="funcionariosTable" paginator="true" paginatorMaxPages="7"/>
			</h:form>		
		</f:view>
	</body>
</html>