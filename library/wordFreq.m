[num] = textread('wordFreqSmallonly');
inteval = [1];
k = 1;
while (k < max(num))
    k = k + ceil(k/100);
    inteval = [inteval, k];
end
split = length(inteval)-1;
point = [];
for i=1:split
    point(i) = (inteval(i)+inteval(i+1))/2;
end
[K] = histc(num, inteval);
plot(log(point'),log(K(1:split,1)+1),'r')
xlabel('log(词频大小)/次')
ylabel('log(词的个数)')
title('大数据集下log(词的个数)与log(词频大小)的关系')
box on
% saveas(gcf,'log-logBig.png')
figure
plot(log(point'),K(1:split,1),'r')
xlabel('log(词频大小)/次')
ylabel('词的个数')
title('大数据集下词的个数与log(词频大小)的关系')
box on
% saveas(gcf,'log-1Big.png')