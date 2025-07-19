class RemoveSubfolders {
    public List<String> removeSubfolders(String[] folder) {
        Set<String> folders = new HashSet<String>(Arrays.asList(folder));
        List<String> ret= new ArrayList<String>();
        for (String fold : folder) {
            int pos = 0;
            boolean deleted = false;
            while ((pos = fold.indexOf("/", pos+1)) !=-1 && !deleted) {
                String temp = fold.substring(0, pos);
                if (folders.contains(temp)){
                    folders.remove(fold);
                    deleted = true;
                }
            }
        }
        return new ArrayList<String>(folders);
    }
}
