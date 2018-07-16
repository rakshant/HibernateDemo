package nov20.com.rakshant.onetoonemapping;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="PROFILETEST")
public class Profile {	

		@Id		
		@GeneratedValue
		@Column(name="profile_id")
		private long profileId;
		
		@Column(name="expertize")
		private String expertize;	
		
		public Profile() {
		}			

		public Profile(String expertize) {		
			this.expertize = expertize;
		}

		public Long getProfileId() {
			return profileId;
		}

		public void setProfileId(Long profileId) {
			this.profileId = profileId;
		}

		public String getExpertize() {
			return expertize;
		}

		public void setExpertize(String expertize) {
			this.expertize = expertize;
		}
}
