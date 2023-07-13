package pojo.user;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.ArrayList;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User{
        public String id;
        public String aaId;
        public boolean activityBlocked;
        public String avatarHash;
        public String avatarUrl;
        public String bio;
        public Object bioData;
        public boolean confirmed;
        public String fullName;
        public Object idEnterprise;
        public ArrayList<Object> idEnterprisesDeactivated;
        public Object idMemberReferrer;
        public ArrayList<Object> idPremOrgsAdmin;
        public String initials;
        public String memberType;
        public boolean nonPublicAvailable;
        public ArrayList<Object> products;
        public String url;
        public String username;
        public String status;
        public Object aaBlockSyncUntil;
        public String aaEmail;
        public Object aaEnrolledDate;
        public String avatarSource;
        public int credentialsRemovedCount;
        public Object domainClaimed;
        public String email;
        public String gravatarHash;
        public ArrayList<String> idBoards;
        public ArrayList<String> idOrganizations;
        public ArrayList<Object> idEnterprisesAdmin;
        public ArrayList<String> loginTypes;
        public ArrayList<Object> messagesDismissed;
        public ArrayList<String> oneTimeMessagesDismissed;
        public ArrayList<Object> trophies;
        public Object uploadedAvatarHash;
        public Object uploadedAvatarUrl;
        public ArrayList<String> premiumFeatures;
        public boolean isAaMastered;
        public String ixUpdate;
}


