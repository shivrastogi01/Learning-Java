class SubDomainVisitCount {
   public List<String> subdomainVisits(String[] cpdomains) {
        if (cpdomains == null || cpdomains.length == 0) return List.of();

        var frequencyMap = new HashMap<String, Integer>();
        for (var eachWebsite : cpdomains) {
            var count = Integer.parseInt(eachWebsite.split(" ")[0]);
            var subDomain = eachWebsite.split(" ")[1];
            var firstDotPos = 0;
            while (firstDotPos != -1) {
                frequencyMap.put(subDomain, frequencyMap.getOrDefault(subDomain, 0) + count);
                firstDotPos = subDomain.indexOf('.');
                subDomain = subDomain.substring(firstDotPos+1);
            }

        }
        return frequencyMap.entrySet().stream().map(entry -> entry.getValue() + " " + entry.getKey()).collect(Collectors.toList());
    }
}