package com.hadronsoft.financaspessoais.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="PARCELALANCAMENTO_PLC")
public class Parcela implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue
	@Column(name = "PLC_ID")
	private Long id;
	
	@Column(name="PLC_DTPARCELA")
	private Date data;
	
	@Column(name="PLC_VLPARCELA")
	private BigDecimal valor;
	
	@ManyToOne
	@JoinColumn(name="PLC_IDLANCAMENTO", nullable = false, foreignKey = @ForeignKey(name="FK1_PARCELALANCAMENTO_LANCAMENTO"))
	private Lancamento lancamento;
	
	
}
