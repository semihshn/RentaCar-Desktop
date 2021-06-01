package application.core.entitie.concretes;

import application.core.entitie.abstracts.Entity;

public class UserOperationClaim implements Entity{
	
	private int id;
	private int userId;
	private int operationClaimId;
	
	public UserOperationClaim() {
		// TODO Auto-generated constructor stub
	}

	public UserOperationClaim(int id, int userId, int operationClaimId) {
		super();
		this.id = id;
		this.userId = userId;
		this.operationClaimId = operationClaimId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getOperationClaimId() {
		return operationClaimId;
	}

	public void setOperationClaimId(int operationClaimId) {
		this.operationClaimId = operationClaimId;
	}
	
	
}
